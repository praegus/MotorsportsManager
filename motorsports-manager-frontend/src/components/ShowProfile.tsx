import { ProfileResponse } from '@/generated-sources';

type Props = {
  data: ProfileResponse
}

export default function ShowProfile({data}: Props) {

  return (
      <div className="w-full flex">
        <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10">
            <p>Welcome! {data.name}</p>
        </div>
    </div>
  );
};
