import { VehicleResponse } from '@/generated-sources';

type Props = {
  data: VehicleResponse
}

export default function ShowProfile({data}: Props) {
  return (
      <div className="w-full flex">
        <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10">
            <h1>Vehicle</h1>
            <p>chassis: {data.chassis}</p>
            <p>engine: {data.engine}</p>
            <p>wheels: {data.wheels}</p>
            <br />
            <button>shop now!</button>
        </div>
    </div>
  );
};
