import axios, { AxiosResponse } from 'axios';

// Erstellt eine Instanz von axios mit vorkonfigurierten Optionen
const axiosApi = axios.create({
  timeout: 1000, // Zeitlimit für Anfragen in Millisekunden (1 Sekunde)
});

// Definition der Datentypen für verschiedene API-Antworten

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

interface Races {
  raceName: string;
  circuitID: number;
  circuitName: string;
  Location: string;
  date: string;
  time: string;
}

// Exportiert verschiedene Funktionen, die HTTP-Anfragen an die API ausführen

export default {
  // Funktion zum Abrufen der Fahrerdaten
  async getDrivers(): Promise<Driver[]> {
    try {
      const response: AxiosResponse = await axios.get('http://localhost:8080/drivers');
      return response.data; 
    } catch (error) {
      console.error(error); 
      return []; 
    }
  },

  // Funktion zum Abrufen der Streckendaten
  async getCircuit(): Promise<Circuit[]> {
    try {
      const response: AxiosResponse = await axios.get('http://localhost:8080/circuits');
      return response.data; 
    } catch (error) {
      console.error(error); 
      return []; 
    }
  },

  // Funktion zum Abrufen der Konstrukteursdaten
  async getConstructors(): Promise<Constructors[]> {
    try {
      const response: AxiosResponse = await axios.get('http://localhost:8080/constructors');
      return response.data; 
    } catch (error) {
      console.error(error); 
      return []; 
    }
  },

  // Funktion zum Abrufen der Rennstreckendaten
  async getRaces(): Promise<Races[]> {
    try {
      const response: AxiosResponse = await axios.get('http://localhost:8080/races');
      return response.data;
    } catch (error) {
      console.error(error);
      return [];
    }
  },
};
