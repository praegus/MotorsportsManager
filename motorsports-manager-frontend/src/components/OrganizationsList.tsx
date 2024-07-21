import {useState, useEffect} from 'react'
import {OrganizationResponse, GetOrganizationByNameRequest, OrganizationApi, ErrorResponse} from "@/generated-sources";
import {useRouter} from 'next/router'
import {ErrorUtil} from '@/utils'
import Link from 'next/link'

export default function OrganizationsList() {
    const [errorResponse, setErrorResponse] = useState<ErrorResponse | null>(null);
    const [data, setData] = useState<OrganizationResponse[]>([]);

    var organizationApi = new OrganizationApi();
    const router = useRouter();

    useEffect(() => {
      const fetchData = async() => {
        try {
          var organizations = await organizationApi.getAllOrganizations();
          setData(organizations);
        } catch (errResponse: any) {
          ErrorUtil.retrieveErrorMessage(errResponse, (json: ErrorResponse) => setErrorResponse(json))
        }
      }
      fetchData();
    }, []);

    async function openOrganization(name: string | undefined) {
      if (!name) return;
      try { 
        await organizationApi.getOrganizationByName({
          name: name
        }).then((res: OrganizationResponse) => {
            router.push(`organizations/${res.name}`)
        });
      } catch (errResponse: any) {
        ErrorUtil.retrieveErrorMessage(errResponse, (json: ErrorResponse) => setErrorResponse(json))
      }
      
    }

  return (
    <div className="flex">
      <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10">
        Organizations: <br/>
        {data.map((item: OrganizationResponse) => 
        <Link key={item.name} className='hover:underline hover:text-gray-500' href={`/profiles/${router.query.profileName}/organizations/${item.name}`}>
          {item.name}
        </Link>
        )}
        <p className="mt-2 text-sm text-red-600 dark:text-red-500">{errorResponse?.detail}</p>
      </div>
    </div>
  );
};
