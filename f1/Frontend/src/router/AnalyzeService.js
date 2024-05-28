import axios from "axios";

class AnalyzeService {
  getDrivers() {
    return axios.get('http://localhost:8081/drivers');
  }
}

export default new AnalyzeService();
