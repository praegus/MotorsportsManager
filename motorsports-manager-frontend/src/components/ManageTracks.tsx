import {useState} from 'react'
import { TrackInfoResponse, RaceApi, ErrorResponse } from '@/generated-sources';
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
              router.reload();
          });
        } catch (errResponse: any) {
          ErrorUtil.retrieveErrorMessage(errResponse, (json: ErrorResponse) => setErrorResponse(json))
        }
      }

  return (
      <div>
      <div className="w-full flex">
        <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10">
            <h1>Next Track</h1>
                {
                  data.length > 0 ?
                    data.filter((record: TrackInfoResponse) => record.status === "UPCOMING")
                        .map((record: TrackInfoResponse, index) => (
                          <div key={index}>
                            <p>Track: {record.name}</p>
                            <p>Status: {record.status}</p>
                            <p>Details: ???</p>
                          </div>
                        ))
                    : 'no info on next track available'
                }
            <br />
            <button>Buy info for 10€</button>
            <br />
            <br />
            <button onClick={startRace}>Race!</button>
        </div>
        </div>
              <div className="w-full flex">
                <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10">
                    <h1>Previous Track(s)</h1>
                        {
                          data.length > 0 ?
                            data.filter((record: TrackInfoResponse) => record.status === "COMPLETED")
                                .map((record: TrackInfoResponse, index) => (
                                  <div key={index}>
                                    <p>Track: {record.name}</p>
                                    <p>Status: {record.status}</p>
                                    <p>Prize money: €{record.prizeMoney}</p>
                                  <br />
                                  </div>
                                ))
                            : 'No tracks completed yet.'
                        }
                </div>
            </div>
        </div>

  );
};
