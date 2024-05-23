import axios, { AxiosResponse } from 'axios';

const axiosApi = axios.create({
  timeout: 1000,
});


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
  constructors(): Promise<AxiosResponse<string>> {
    return axiosApi.get(`/constructors`);
  },
};