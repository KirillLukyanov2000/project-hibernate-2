package ru.javarush.lukyanov.hibernate2.service.util;


import ru.javarush.lukyanov.hibernate2.repository.*;


public class RepositoryProvider {
    private ActorRepository actorRepository = null;
    private AddressRepository addressRepository = null;
    private CategoryRepository categoryRepository = null;
    private CityRepository cityRepository = null;
    private CountryRepository countryRepository = null;
    private CustomerRepository customerRepository = null;
    private FilmRepository filmRepository = null;
    private FilmTextRepository filmTextRepository = null;
    private InventoryRepository inventoryRepository = null;
    private LanguageRepository languageRepository = null;
    private PaymentRepository paymentRepository = null;
    private RentalRepository rentalRepository = null;
    private StaffRepository staffRepository = null;
    private StoreRepository storeRepository = null;

    public ActorRepository getActorRepository() {
        return actorRepository = new ActorRepository();
    }

    public AddressRepository getAddressRepository() {
        return addressRepository = new AddressRepository();
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository = new CategoryRepository();
    }

    public CityRepository getCityRepository() {
        return cityRepository = new CityRepository();
    }

    public CountryRepository getCountryRepository() {
        return countryRepository = new CountryRepository();
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository = new CustomerRepository();
    }

    public FilmRepository getFilmRepository() {
        return filmRepository = new FilmRepository();
    }

    public FilmTextRepository getFilmTextRepository() {
        return filmTextRepository = new FilmTextRepository();
    }

    public InventoryRepository getInventoryRepository() {
        return inventoryRepository = new InventoryRepository();
    }

    public LanguageRepository getLanguageRepository() {
        return languageRepository = new LanguageRepository();
    }

    public PaymentRepository getPaymentRepository() {
        return paymentRepository = new PaymentRepository();
    }

    public RentalRepository getRentalRepository() {
        return rentalRepository = new RentalRepository();
    }

    public StaffRepository getStaffRepository() {
        return staffRepository = new StaffRepository();
    }

    public StoreRepository getStoreRepository() {
        return storeRepository = new StoreRepository();
    }
}
