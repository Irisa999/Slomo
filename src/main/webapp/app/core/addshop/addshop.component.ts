import Vue from 'vue';
import { Component, Inject } from 'vue-property-decorator';
import { maxLength, minLength, required } from 'vuelidate/lib/validators';
import ShopService from '@/core/addshop/addshop.service';
import { SHOP_ALREADY_USED_TYPE } from '@/constants';

const validations: any = {
  addShop: {
    name: {
      required,
      minLength: minLength(5),
      maxLength: maxLength(50),
    },
    country: {
      required,
      minLength: minLength(5),
      maxLength: maxLength(254),
    },
    city: {
      required,
      minLength: minLength(5),
      maxLength: maxLength(254),
    },
    description: {
      required,
      minLength: minLength(5),
      maxLength: maxLength(254),
    },
    address: {
      required,
      minLength: minLength(5),
      maxLength: maxLength(254),
    },
    category: {
      required,
    },
    postal_code: {
      minLength: minLength(5),
      maxLength: maxLength(15),
      required,
    },
    donate: {
      required,
    },
  },
};

@Component({
  validations,
})
export default class AddShop extends Vue {
  @Inject('shopService') private shopService: () => ShopService;
  public addShop: any = {
    name: undefined,
    country: undefined,
    city: undefined,
    address: undefined,
    description: undefined,
    category: undefined,
    postal_code: undefined,
    donate: undefined,
  };

  public error = '';
  public errorShopExists = '';
  public success = false;

  public addshop(): void {
    this.error = null;
    this.errorShopExists = null;
    this.addShop.langKey = this.$store.getters.currentLanguage;
    this.shopService()
      .processAddShop(this.addShop)
      .then(() => {
        this.success = true;
      })
      .catch(error => {
        this.success = null;
        if (error.response.status === 400 && error.response.data.type === SHOP_ALREADY_USED_TYPE) {
          this.errorShopExists = 'ERROR';
        } else {
          this.error = 'ERROR';
        }
      });
  }
}
