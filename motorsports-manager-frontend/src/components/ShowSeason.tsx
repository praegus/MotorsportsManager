import { SeasonRegistrationResponse } from '@/generated-sources';

type Props = {
  data: SeasonRegistrationResponse
}

export default function ShowProfile({data}: Props) {
  return (
      <div className="w-full flex">
        <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10">
          <h1>Season</h1>
          <p>seasonName: {data.name}</p>
          <p>balance: €{data.accountBalance}</p>
          <p>class: {data.racingClass}</p>
        </div>
    </div>
  );
};
