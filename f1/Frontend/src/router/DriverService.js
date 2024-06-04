import axios from "axios";

class DriverService {
  getDrivers() {
    return axios.get('http://ergast.com/api/f1/2024/drivers.json');
  }
}

export default new DriverService();
