import axios from 'axios';

export function getShops(city: string): Promise<Shop[]> {
  // Make a request to the API to get the list of slow-fashion shops in the given city
  return axios.get(`/shops?city=${city}`).then(response => response.data);
}

export function filterShops(shops: Shop[], types: string[]): Shop[] {
  // Filter the list of shops by the given shop types
  return shops.filter(shop => types.includes(shop.type));
}

interface Shop {
  name: string;
  type: string;
}
