import ShowProfile from '@/components/ShowProfile';
import SelectOrganization from '@/components/OrganizationForm';
import OrganizationsList from '@/components/OrganizationsList';
import NavBar from '@/components/NavBar';

export default function Profile() {
  return (
      <div>
        <NavBar />
        <SelectOrganization />
        <OrganizationsList />
        <ShowProfile />
    </div>
  );
};

