import axios from 'axios';

export default class AddShopService {
  public processAddShop(addshop: any): Promise<any> {
    return axios.post('/shop', addshop);
  }
}
