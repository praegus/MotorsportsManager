import {useState} from 'react'
import { TrackInfoResponse, RaceApi } from '@/generated-sources';
import { useRouter } from 'next/router'
import {ErrorUtil} from '../utils'

type Props = {
  data: TrackInfoResponse[]
}

export default function ManageTracks({data}: Props) {
    const [errorResponse, setErrorResponse] = useState<ErrorResponse | null>(null);
  const router = useRouter();
  var raceApi = new RaceApi();

  async function startRace(){
      try {

          await raceApi.startRace({
              raceId: "TUTORIAL"
          }).then(() => {
              router.reload('/');
          });
        } catch (errResponse: any) {
          ErrorUtil.retrieveErrorMessage(errResponse, (json: ErrorResponse) => setErrorResponse(json))
        }
      }

  async function createProfile(name: string) {
      try {
        let createProfileRequest:CreateProfileRequest = {
            name: name
        };

        await profileApi.createProfile({
            createProfileRequest: createProfileRequest
        }).then(() => {
            router.push(`profile?name=${name}`)
        });
      } catch (errResponse: any) {
        ErrorUtil.retrieveErrorMessage(errResponse, (json: ErrorResponse) => setErrorResponse(json))
      }
    }

  return (
      <div className="w-full flex">
        <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10">
            <h1>Next Track</h1>
            {data.length > 0 ?
            data?.map((record: TrackInfoResponse, index) =>
              <div key={index}>
                <p>Track: {record.name}</p>
                <p>Status: {record.status}</p>
                <p>Details: ???</p>
              </div>
            )
            : `no info on current tracks!`}
            <br />
            <button>Buy info for 10€</button>
            <br />
            <br />
            <button onClick={startRace}>Race!</button>
        </div>
    </div>
  );
};
