import Component from 'vue-class-component';
import { Inject, Prop, Watch, Vue } from 'vue-property-decorator';
import LoginService from '@/account/login.service';

@Component
export default class Explore extends Vue {
  @Inject('loginService')
  private loginService: () => LoginService;

  // Define the city property as a reactive property
  @Prop({ default: '' })
  public city!: string;

  // Define the stores property as a reactive property
  @Prop({ default: () => [] })
  public stores!: string[];

  // Automatically update the showStores computed property when the city or stores properties change
  @Watch('city')
  @Watch('stores')
  public onPropertyChanged() {
    this.showStores = this.city !== '' && this.stores.length > 0;
  }

  public openLogin(): void {
    this.loginService().openLogin((<any>this).$root);
  }

  public authenticated: boolean = this.$store.getters.authenticated;

  public username: string = this.$store.getters.account?.login ?? '';

  // Define the showStores property as a computed property
  public get showStores() {
    return this.city !== '' && this.stores.length > 0;
  }

  public set showStores(value: boolean) {
    // ...
  }

  public searchStores() {
    // Replace this with a call to a search engine that returns stores in the given city
    this.stores;
  }
}
