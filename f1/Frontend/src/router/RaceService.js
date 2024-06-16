import axios from "axios";

class DashboardService {
  getRaces() {
    return axios.get('http://localhost:8050/race'); // Führt eine GET-Anfrage an die URL 'http://localhost:8050/race' aus.
  }
}

export default new DashboardService();
