import { ProfileResponse, SeasonRegistrationResponse, TrackRecordResponse } from '@/generated-sources';
import { useRouter } from 'next/router'

export default function ShowProfile({data}) {
  const router = useRouter();

  function getSeason(): SeasonRegistrationResponse {
    return data.seasonRegistrations[0];
  }
  return (
      <div className="w-full flex">
        <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10">
            <p>Welcome! {router.query.name}</p>
            <p>seasonName: {getSeason().name}</p>
            <p>balance: {getSeason().accountBalance}</p>
            <p>class: {getSeason().racingClass}</p>

            <h1>Vehicle</h1>
            <p>chassis: {getSeason().vehicle?.chassis}</p>
            <p>engine: {getSeason().vehicle?.engine}</p>
            <p>wheels: {getSeason().vehicle?.wheels}</p>

            <h1>TrackInfo</h1>
            {getSeason().trackRecords.length > 0 ?
            getSeason().trackRecords?.map((record: TrackRecordResponse) => `<p>${record.name}:${record.status}:${record.prizeMoney}</p>`)
            : `no info on current tracks!`}
        </div>
    </div>
  );
};
