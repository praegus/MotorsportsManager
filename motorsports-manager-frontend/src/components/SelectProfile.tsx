import {useState, FormEvent} from 'react'
import {ProfileApi, ProfileRequest} from "../generated-sources";
import {useRouter} from 'next/router'
import ErrorUtil from '../utils/ErrorUtil'

export default function SelectProfile() {
    const [error, setError] = useState<string | null>(null);

    var profileApi = new ProfileApi();
    const router = useRouter();

    async function onSubmit(event: FormEvent<HTMLFormElement>) {
        setError(null)
        event.preventDefault();
        const formData = new FormData(event.currentTarget);
        const chosenName = (formData.get("name")! as string);

        var profileRequest:ProfileRequest = {
            name: chosenName
        };

        await profileApi.createProfile({
            profileRequest: profileRequest
        }).then(() => {
            router.push(`profile?name=${chosenName}`)
        }, (errResponse) => {
            ErrorUtil.retrieveErrorMessage(errResponse, (errorMessage: string) => setError(errorMessage));
        });
  }

  return (
    <div className="w-full flex">
      <form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10" onSubmit={onSubmit}>
        <div className="mb-4">
          <label htmlFor="profileName">
            Profile
          </label>
          <input name="name" type="text" placeholder="ProfileName" />
          {error && <p className="mt-2 text-sm text-red-600 dark:text-red-500">{error}</p>}
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
