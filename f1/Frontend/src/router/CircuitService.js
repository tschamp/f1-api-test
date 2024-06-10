import axios from "axios";

class CircuitService {
  getCircuit() {
    return axios.get('http://localhost:8081/circuits');
  }
}

export default new CircuitService();