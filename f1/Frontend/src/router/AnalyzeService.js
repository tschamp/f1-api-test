import axios from "axios";

class AnalyzeService {
  getDrivers() {
    return axios.get('http://ergast.com/api/f1/2024/drivers.json');
  }
}

export default new AnalyzeService();
