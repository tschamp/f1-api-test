import axios from "axios";

class RaceService {
  getRaces() {
    return axios.get('http://localhost:8081/race');
  }
}

export default new RaceService();
