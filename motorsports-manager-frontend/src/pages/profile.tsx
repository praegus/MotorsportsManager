import ShowProfile from '../components/ShowProfile';
import {useState, useEffect} from 'react'
import NavBar from '../components/NavBar';
import {ErrorResponse, ProfileApi, ProfileResponse} from '@/generated-sources';
import { ErrorUtil } from '@/utils';
import { useRouter } from 'next/router';

export default function Profile() {
  const [errorResponse, setErrorResponse] = useState<ErrorResponse | null>(null);
  const [data, setData] = useState<ProfileResponse>();
  var profileApi = new ProfileApi();
  const router = useRouter();

  useEffect(() => {
    const fetchData = async() => {
      try {
        var profiles = await profileApi.getProfileByName({
          name: router.query.name
        });
        setData(profiles);
      } catch (errResponse: any) {
        ErrorUtil.retrieveErrorMessage(errResponse, (json: ErrorResponse) => setErrorResponse(json))
      }
    }
    fetchData();
  }, []);

  return (
      <div>
        <NavBar />
        { data? <ShowProfile data={data} /> : 'no data' }
    </div>
  );
};

