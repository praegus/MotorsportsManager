import {useState, useEffect, FormEvent} from 'react'
import {TeamsApi, TeamRequest} from "../generated-sources";

export default function Start() {
    const [data, setData] = useState([]);
    var teamsApi = new TeamsApi();

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
        }, (err) => {
            console.log('error');
        });
  }

  return (
    <div className="w-full max-w-xs">
      <form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4" onSubmit={onSubmit}>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="profileName">
            Profile
          </label>
          <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" name="name" type="text" placeholder="ProfileName" />
        </div>
        <div className="flex items-center justify-between">
          <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="submit">
            Sign In
          </button>
        </div>
      </form>
    </div>
  );
};
