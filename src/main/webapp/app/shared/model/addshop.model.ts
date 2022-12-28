export interface IShop {
  id?: any;
  name?: string;
  country?: string;
  city?: string;
  address?: string;
  description?: string;
  postal_code?: string;
  category?: string;
  donations?: boolean;
  createdBy?: string;
  createdDate?: Date;
  lastModifiedBy?: string;
  lastModifiedDate?: Date;
}

export class Shop implements IShop {
  constructor(
    public id?: any,
    public name?: string,
    public country?: string,
    public city?: string,
    public address?: string,
    public description?: string,
    public postal_code?: string,
    public category?: string,
    public donations?: boolean,
    public createdBy?: string,
    public createdDate?: Date,
    public lastModifiedBy?: string,
    public lastModifiedDate?: Date
  ) {}
}
