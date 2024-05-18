import axios, { AxiosResponse } from 'axios';

interface Driver {
  id: number;
  name: string;
  team: string;
}

export default {
  async getDrivers(): Promise<Driver[]> {
    try {
      const response: AxiosResponse = await axios.get('http://localhost:8080/drivers');
      return response.data;
    } catch (error) {
      console.error(error);
      return [];
    }
  },
};