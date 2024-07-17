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

        const formData = new FormData(event.currentTarget);
        const chosenName = (formData.get("name")! as string);
        console.log((event.nativeEvent as SubmitEvent).submitter)

        var action = ((event.nativeEvent as SubmitEvent).submitter as HTMLInputElement).value;
        switch (action) {
          case 'create': 
            createProfile(chosenName);
            break;
          case 'select':
            SelectExistingProfile(chosenName);
            break;
          default:
            setError(`${action} does not work.`)
        }
  }
  async function createProfile(name: string) {
    try {
      var profileRequest:ProfileRequest = {
          name: name
      };

      await profileApi.createProfile({
          profileRequest: profileRequest
      }).then(() => {
          router.push(`profile?name=${name}`)
      });
    } catch (errResponse) {
      ErrorUtil.retrieveErrorMessage(errResponse as ResponseError, (errorMessage: string) => setError(errorMessage));
    }
  }
  async function SelectExistingProfile(name: string) {
    try {
      await profileApi.getProfileByName({
        name: name
      }).then(() => {
          router.push(`profile?name=${name}`)
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
          <button type="submit" value="create">Create</button>
          <button type="submit" value="select">Login</button>
        </div>
      </form>
    </div>
  );
};
