import axios from "axios";

class ConstructorService {
  getConstructors() {
    return axios.get('http://localhost:8050/constructors'); // Führt eine GET-Anfrage an die URL 'http://localhost:8050/constructors' aus.
  }
}

export default new ConstructorService();
