import axios from "axios";

class CircuitService {
  getCircuit() {
    return axios.get('http://localhost:8050/circuits'); // Führt eine GET-Anfrage an die URL 'http://localhost:8050/circuits' aus.
  }
}

export default new CircuitService();
