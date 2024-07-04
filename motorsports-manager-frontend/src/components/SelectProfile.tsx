import {useState, FormEvent} from 'react'
import {ProfileApi, ProfileRequest, ResponseError} from "../generated-sources";
import {useRouter} from 'next/router'
import {ErrorUtil} from '../utils'

export default function SelectProfile() {
    const [error, setError] = useState<string | null>(null);

    var profileApi = new ProfileApi();
    const router = useRouter();

    async function onSubmit(event: FormEvent<HTMLFormElement>) {
        setError(null)
        event.preventDefault();

        try {
          const formData = new FormData(event.currentTarget);
          const chosenName = (formData.get("name")! as string);

          var profileRequest:ProfileRequest = {
              name: chosenName
          };

          await profileApi.createProfile({
              profileRequest: profileRequest
          }).then(() => {
              router.push(`profile?name=${chosenName}`)
          });
        } catch (errResponse) {
          ErrorUtil.retrieveErrorMessage(errResponse as ResponseError, (errorMessage: string) => setError(errorMessage));
        }

  }

  return (
    <div className="w-full flex">
      <form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10" onSubmit={onSubmit}>
        <div className="mb-4">
          <label htmlFor="profileName">
            Profile
          </label>
          <input name="name" className={error? 'border-1 border-rose-500':''} type="text" placeholder="ProfileName" />
          <p className="mt-2 text-sm text-red-600 dark:text-red-500">{error}</p>
        </div>
        <div className="flex items-center justify-between">
          <button type="submit">
            Create
          </button>
        </div>
      </form>
    </div>
  );
};
