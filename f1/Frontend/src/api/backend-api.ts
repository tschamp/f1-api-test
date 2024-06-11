import axios, { AxiosResponse } from 'axios';

const axiosApi = axios.create({
  baseURL: 'API',
  timeout: 1000,
});

interface Circuit {
 name: string;
 location: string;
 lat: string;
 long: string;
}


interface Driver {
  id: number;
  name: string;
  team: string;
}

interface Constructors {
  constructorId: number;
  url: string;
  name: string;
  country: string;
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
  async getCircuit(): Promise<Circuit[]> {
    try {
      const response: AxiosResponse = await axios.get('http://localhost:8080/circuits');
      return response.data;
    } catch (error) {
      console.error(error);
      return [];
    }

  },
  async getConstructors(): Promise<Circuit[]> {
    try {
      const response: AxiosResponse = await axios.get('http://localhost:8080/constructors');
      return response.data;
    } catch (error) {
      console.error(error);
      return [];
    }

  },
};