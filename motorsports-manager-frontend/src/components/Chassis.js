import {useState, useEffect} from "react";
import {ChassisApi, ChassisResponse} from "../generated-sources";

const Chassis = () => {
  const [data, setData] = useState([]);
  var chassisApi = new ChassisApi();
  useEffect(() => {
      const fetchData = async() => {
        var chassis = await chassisApi.getChassis();
        setData(chassis);
        console.log('test', chassis)
      }
      fetchData();
  })

  return (
    <div className="flex">
      <div className="p-4 sm:ml-64">
        Found chassis:
        <ul className="flex-1">
            {data.map(item => <li>{item.name}:{item.color}</li>)}
        </ul>
      </div>
    </div>
  );
};

export default Chassis;
