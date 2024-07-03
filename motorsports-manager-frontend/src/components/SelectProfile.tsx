import {useState, useEffect, FormEvent} from 'react'
import {TeamsApi, TeamRequest} from "../generated-sources";
import { useRouter } from 'next/router'

export default function SelectProfile() {
    const [data, setData] = useState([]);
    var teamsApi = new TeamsApi();
    const router = useRouter();

    async function onSubmit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();
        var teamRequest:TeamRequest = {
            name: event.target[0].value,
            slogan: "test"
        };

        await teamsApi.createTeam({
            teamRequest: teamRequest
        }).then(() => {
            console.log('ok');
            router.push(`profile?name=${event.target[0].value}`)
        }, (err) => {
            console.log('error');
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
        </div>
        <div className="flex items-center justify-between">
          <button type="submit">
            Sign In
          </button>
        </div>
      </form>
    </div>
  );
};
