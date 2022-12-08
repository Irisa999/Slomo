import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import Explore from '@/core/explore/explore.vue';
import ExploreClass from '@/core/explore/explore.component';
import * as config from '@/shared/config/config';

const localVue = createLocalVue();
config.initVueApp(localVue);
const store = config.initVueXStore(localVue);
const i18n = config.initI18N(localVue);
localVue.component('router-link', {});

describe('Explore', () => {
  let explore: ExploreClass;
  let wrapper: Wrapper<ExploreClass>;
  const loginService = { openLogin: jest.fn() };

  beforeEach(() => {
    wrapper = shallowMount<ExploreClass>(Explore, {
      i18n,
      store,
      localVue,
      provide: {
        loginService: () => loginService,
      },
    });
    explore = wrapper.vm;
  });

  it('should not have user data set', () => {
    expect(explore.authenticated).toBeFalsy();
    expect(explore.username).toBe('');
  });

  it('should have user data set after authentication', () => {
    store.commit('authenticated', { login: 'test' });

    expect(explore.authenticated).toBeTruthy();
    expect(explore.username).toBe('test');
  });

  it('should use login service', () => {
    explore.openLogin();

    expect(loginService.openLogin).toHaveBeenCalled();
  });
});
