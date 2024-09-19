import SelectProfile from '../components/SelectProfile';
import NavBar from '../components/NavBar';

export default function Home() {
  return (
    <div>
        <NavBar data={null} />
        <SelectProfile />
    </div>
  );
};
