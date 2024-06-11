import axios from "axios";

class ConstructorService {
  getConstructors() {
    return axios.get('http://localhost:8081/constructors');
  }
}

export default new ConstructorService();
