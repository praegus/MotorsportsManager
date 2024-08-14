import ShowSeason from '../components/ShowSeason';
import ManageTracks from '../components/ManageTracks';
import ManageVehicle from '../components/ManageVehicle';
import {useState, useEffect} from 'react'
import NavBar from '../components/NavBar';
import {ErrorResponse, ProfileApi, ProfileResponse} from '@/generated-sources';
import { ErrorUtil } from '@/utils';
import { useRouter } from 'next/router';

export default function Profile() {
  const [errorResponse, setErrorResponse] = useState<ErrorResponse | null>(null);
  const [data, setData] = useState<ProfileResponse>();
  var profileApi = new ProfileApi();
  const router = useRouter();

  useEffect(() => {
    const fetchData = async() => {
      var profileName = 
        Array.isArray(router.query.name)? router.query.name[0] : 
        router.query.name!;
      try {
        var profiles = await profileApi.getProfileByName({
          name: profileName
        });
        setData(profiles);
      } catch (errResponse: any) {
        ErrorUtil.retrieveErrorMessage(errResponse, (json: ErrorResponse) => setErrorResponse(json))
      }
    }
    if(router.isReady) fetchData();
  }, [router.isReady]);

  return (
      <div>
        <NavBar data={data?.name} />
        { data && data.seasonRegistrations && data.seasonRegistrations[0].vehicle && data.seasonRegistrations[0].trackInfo?
        <div>
          <div className="w-full flex">
            <div className="flex-1">
              <ShowSeason data={data.seasonRegistrations[0]} />
            </div>
            <div className="flex-1">
              <ManageVehicle data={data.seasonRegistrations[0].vehicle} />
            </div>
            <div className="flex-1">
              <ManageTracks data={data.seasonRegistrations[0].trackInfo} />
            </div>
          </div>
        </div>
        : 'no data' }
    </div>
  );
};

