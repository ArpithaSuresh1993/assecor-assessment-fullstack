export class PersonAndColorModel
{
  id: number;
  name: string;
  lastname: string;
  zipcode: string;
  city: string;
  color: string;

  constructor (id: number, name: string, lastname: string, zipcode: string, city: string, color: string)
  {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
    this.zipcode = zipcode;
    this.city = city;
    this.color = color;
  }
}
