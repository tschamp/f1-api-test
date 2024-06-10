import axios from "axios";

class DriverService {
  getDrivers() {
    return axios.get('http://localhost:8081/drivers');
  }
}

export default new DriverService();
