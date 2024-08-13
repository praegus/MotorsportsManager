import { TrackRecordResponse } from '@/generated-sources';
import { useRouter } from 'next/router'

type Props = {
  data: TrackRecordResponse[]
}

export default function ShowProfile({data}: Props) {
  const router = useRouter();

  return (
      <div className="w-full flex">
        <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10">
            <h1>Next Track</h1>
            {data.length > 0 ?
            data?.map((record: TrackRecordResponse, index) => 
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
            <button>Race!</button>
        </div>
    </div>
  );
};
