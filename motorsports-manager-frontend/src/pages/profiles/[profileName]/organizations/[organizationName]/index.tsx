import NavBar from '@/components/NavBar';
import ShowOrganization from '@/components/ShowOrganization';
import ShowProfile from '@/components/ShowProfile';

export default function Organization() {
  return (
      <div>
        <NavBar />
        <ShowProfile />
        <ShowOrganization />
    </div>
  );
};

