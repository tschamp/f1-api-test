import axios from "axios";

class DashboardService {
  getRaces() {
    return axios.get('http://localhost:8081/race');
  }
}

export default new DashboardService();
