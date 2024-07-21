import { useRouter } from 'next/router'

export default function ShowOrganization() {
  const router = useRouter();
  return (
      <div className="w-full flex">
        <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 m-auto mt-10">
            <p data-testid='organizationGreeter'>Organization: {router.query.organizationName}</p>
        </div>
    </div>
  );
};
