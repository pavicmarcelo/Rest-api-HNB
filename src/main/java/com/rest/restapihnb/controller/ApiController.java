package com.rest.restapihnb.controller;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.restapihnb.dto.UserProductDTO;
import com.rest.restapihnb.model.Product;
import com.rest.restapihnb.model.ExchangeHNB;
import com.rest.restapihnb.model.User;
import com.rest.restapihnb.repository.ProductRepo;
import com.rest.restapihnb.repository.UserRepo;


import com.rest.restapihnb.service.UserService;
import net.minidev.json.JSONArray;


import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.JSONParser;


import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.List;

@RestController
@RequestMapping("/exchange")
public class ApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUserProductDTO")
    public List<UserProductDTO> getAllUserProductDTO() {

        return userService.getAllUsersProducts();
    }



/*
    @RequestMapping (value = "/products", method = RequestMethod.GET, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    @PostMapping(value = "/saveProduct")
    public Product saveProduct(@RequestBody Product product) {
        productRepo.save(product);
        return product;
    }



    @GetMapping(value = "/users")
    public List<User> findAllUsers() { return userRepo.findAll(); }

    @PostMapping(value = "/saveUser")
    public User saveUser(@RequestBody User user) {
        userRepo.save(user);
        return user;
    }

    @PutMapping(value = "updateUser/{id}")
    public String updateUser (@PathVariable long id, @RequestBody User user) {
        User updatedUser = userService.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        userRepo.save(updatedUser);
        return "Updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser (@PathVariable long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "User with id: " + id + " is deleted!";
    }
*/

    @GetMapping(value = "/exchangeRateEUR")  // kopirano u hnbController
    public JSONArray getCurrencyExchangeRate() throws net.minidev.json.parser.ParseException {
        String url = "https://api.hnb.hr/tecajn/v1?valuta=EUR";

        RestTemplate restTemplate = new RestTemplate();

        JSONArray exchangeRateEUR = restTemplate.getForObject(url, JSONArray.class);

     //  String returnValue = Arrays.asList(exchangeRateEUR).toString();

     //   ObjectMapper mapper = new ObjectMapper();

     //   System.out.println("povratna vrijednost: \n" + returnValue);

        System.out.println("\n test33434 = " + exchangeRateEUR.get(0).toString());

       // exchangeRateEUR.get(0).toString();

        JSONParser parser = new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(exchangeRateEUR.toString());


        System.out.println("\n test  77777 = " + jsonArray.get(0).toString() ) ;


        return exchangeRateEUR;
    }

    @GetMapping(value = "/exchangeRate")
    public Object getCurrencyExchangeRate2() throws ParseException, net.minidev.json.parser.ParseException {
        String url = "https://api.hnb.hr/tecajn/v1?valuta=EUR";


        JSONArray exchangeHNB = getCurrencyExchangeRate();


        JSONParser jsonParser = new JSONParser();

/*
        Object obj =  jsonParser.parse(exchangeHNB.toString());

        JSONArray array = new JSONArray();

        array.add(obj);
*/

/*
        JSONObject jbo = (JSONObject) obj;


        String value = (String) jbo.get("Valuta");


       JSONArray jsonArray = (JSONArray) jbo.get("Valuta");



        System.out.println("\nValue : " + value);

        System.out.println("\n JSONArray : " + jsonArray);


        Iterator<Object> iterator = jsonArray.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
*/

        JSONObject obj2=(JSONObject) JSONValue.parse(exchangeHNB.toString());
        JSONArray arr=(JSONArray)obj2.get("Valuta");
        System.out.println(arr.get(1));


      //  System.out.println("\n5. array : " +  array.get(4));

return exchangeHNB;


    }


    @GetMapping(value = "/try1")
    public Object anotherTry () throws IOException {
        URL url = new URL("https://api.hnb.hr/tecajn/v1?valuta=EUR");

        URLConnection request = url.openConnection();
        request.connect();

        ArrayList<Object> objekt = new ArrayList<>();

        ExchangeHNB exchangeHNB = new ExchangeHNB();

        ObjectMapper mapper = new ObjectMapper();

        objekt = mapper.readValue(url, ArrayList.class);

        Map<String,Object> map = mapper.readValue(url, Map.class);

        System.out.print("map bi trebao biti: " + map.get("Valuta"));


        return objekt;

    }


    @GetMapping(value = "/try2")
  //  @RequestBody()
    public void try2() throws IOException, net.minidev.json.parser.ParseException {

        String jsonStr = getObject().toString();

        JSONArray jsonArray = (JSONArray) getObject();

        System.out.println(jsonArray.get(0));

        Map<String, Object> map;

        ObjectMapper objectMapper = new ObjectMapper();



    //    String allCargo = jsonObject.getAsString("Valuta");





       // System.out.println("try2 valuta = " + map.get("Valuta"));



    }



    @GetMapping(value = "/getSrednjiZaDevize")
    public BigDecimal getSrednjiZaDevize() throws Exception {

        String srednjiTecajString = null;

        Object jsonObject = getCurrencyExchangeRate();

        if (jsonObject == null) {
            System.out.println("json is empty");
        } else {

            JSONArray this_is_jsonArray = (JSONArray)jsonObject;
            LinkedHashMap<String, Object> nov =  (LinkedHashMap)this_is_jsonArray.get(0);
            srednjiTecajString = (String) nov.get("Srednji za devize");
            if (srednjiTecajString != null) {
                srednjiTecajString = srednjiTecajString.replace(",", ".");

            } else {
                throw new Exception("srednjiTecajString je null!");
            }

        }


        return new BigDecimal(srednjiTecajString);

    }



    @GetMapping(value = "/getJsonArray")
    public JSONArray getJsonArray() {
        String url = "https://api.hnb.hr/tecajn/v1?valuta=EUR";

        RestTemplate restTemplate = new RestTemplate();

        JSONArray exchangeRateEUR =  restTemplate.getForObject(url, JSONArray.class);


        ExchangeHNB readValueForMapper = new ExchangeHNB();


        return exchangeRateEUR;
    }



    @GetMapping(value = "/getObject")
    public Object getObject() {
        String url = "https://api.hnb.hr/tecajn/v1?valuta=EUR";

        RestTemplate restTemplate = new RestTemplate();

        Object exchangeRateEUR =   restTemplate.getForObject(url, Object.class);

        ArrayList arrayList = (ArrayList) exchangeRateEUR;

        String valuta = arrayList.get(0).toString();

        System.out.println("valuta iz objekta je = " + valuta);

        return exchangeRateEUR;
    }



    @GetMapping(value = "/getSrednji2")
    public void getSrednji2() throws net.minidev.json.parser.ParseException {

        ExchangeHNB exchangeHNB = new ExchangeHNB();

        String valuta = null;
        String datum = null;
        ArrayList jsonarray = (ArrayList)getObject();
        for (int i = 0; i < jsonarray.size(); i++) {
             LinkedHashMap jsonobject = (LinkedHashMap)jsonarray.get(i);

             valuta = (String) jsonobject.get("Dr\u017eava");
             datum = (String)jsonobject.get("Datum primjene");

             exchangeHNB.setDrzava((String) jsonobject.get("Dr\u017eava"));
         //    exchangeHNB.setBrojTecajnice();

           // č  - \u010d
           // š  - \u0161




        }

        String s = "\u0160";

        System.out.println(valuta);
        System.out.println(datum);


        System.out.println(s);

    }



    @GetMapping(value = "/getSrednji3")
    public void getSrednji3() throws net.minidev.json.parser.ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray json = getCurrencyExchangeRate();



        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList usrPost = mapper.readValue(new URL("https://api.hnb.hr/tecajn/v1?valuta=EUR"), ArrayList.class);
            System.out.println(usrPost);
            String value = usrPost.get(0).toString();
            System.out.println(value);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }




    @GetMapping(value = "/getSrednji4")   // prebačeno u HNBController
    public void getSrednji4() throws net.minidev.json.parser.ParseException, IOException {

        String url = "https://api.hnb.hr/tecajn/v1?valuta=EUR";

        RestTemplate restTemplate = new RestTemplate();

        JSONArray exchangeRateEUR = restTemplate.getForObject(url, JSONArray.class);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(exchangeRateEUR.toString());


        System.out.println("\n test  77777 = " + jsonArray.get(0).toString() ) ;



        JSONArray json = getCurrencyExchangeRate();

        String jsonToString = json.get(0).toString();

        System.out.println("JsonToString = " + jsonToString);

        ObjectMapper objectMapper = new ObjectMapper();

       // String respData = objectMapper.writeValueAsString(json.getBody());

        ExchangeHNB exchangeHNB = objectMapper.readValue( jsonArray.get(0).toString(), ExchangeHNB.class);


        System.out.println("Srednji tečaj 4 : " + exchangeHNB.getSrednjiZaDevize());




    }


}
