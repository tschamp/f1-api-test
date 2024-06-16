import axios from "axios";

class DriverService {
  getDrivers() {
    return axios.get('http://localhost:8050/drivers'); // Führt eine GET-Anfrage an die URL 'http://localhost:8050/drivers' aus.
  }
}

export default new DriverService();
