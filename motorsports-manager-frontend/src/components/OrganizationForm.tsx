import {useState, FormEvent} from 'react'
import {OrganizationRequest, OrganizationApi, ErrorResponse, FieldError} from "../generated-sources";
import {useRouter} from 'next/router'
import {ErrorUtil} from '../utils'

export default function SelectOrganization() {
  const [errorResponse, setErrorResponse] = useState<ErrorResponse | null>(null);

  var organizationApi = new OrganizationApi();
  const router = useRouter();

  async function onSubmit(event: FormEvent<HTMLFormElement>) {
    setErrorResponse(null)
    event.preventDefault();

    const formData = new FormData(event.currentTarget);
    const name = (formData.get("name")! as string);

    try {
      var organizationRequest:OrganizationRequest = {
          name: name
      };

      await organizationApi.createOrganization({
        organizationRequest: organizationRequest
      }).then(() => {
          router.push(`organizations/${name}`)
      });
    } catch (errResponse: any) {
      ErrorUtil.retrieveErrorMessage(errResponse, (json: ErrorResponse) => setErrorResponse(json))
    }
    
  }
  
  function getFieldErrors(field: string): FieldError[] {
    if (!errorResponse || !errorResponse.errors) return [];
    return errorResponse.errors.filter(error => error.field === field)
  }
  function noFieldErrorMessages() {
    console.log('test', errorResponse)
    return errorResponse && (!errorResponse.errors || !errorResponse.errors.length);
  }

  return (
    <div className="w-full flex">
      <form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10" onSubmit={onSubmit}>
        <div className="mb-4">
          <label htmlFor="organizationName">
            Organization
          </label>
          <input name="name" className={getFieldErrors('name').length ? 'border-1 border-rose-500':''} type="text" placeholder="organizationName" />
          {getFieldErrors('name')
            .map((fieldError, index) => 
              <p className="mt-2 text-sm text-red-600 dark:text-red-500" key={index}>{fieldError.error}</p>
            )
          }
          
        </div>
        <p className="mt-2 text-sm text-red-600 dark:text-red-500">{noFieldErrorMessages()?errorResponse?.detail:''}</p>
        <div className="flex items-center justify-between">
          <button type="submit" value="create">Create</button>
        </div>
      </form>
    </div>
  );
};
