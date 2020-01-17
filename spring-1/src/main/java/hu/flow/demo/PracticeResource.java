package hu.flow.demo;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PracticeResource {

    List<Log> logList = new ArrayList<>();


    private static final String NAME = "Dora Molnar";
    private static final String HOST_NAME = "dora";
    private static final String IP_ADRESS = "192.168.5.74";

    @GetMapping
    String getUserData() {return "My name is " + NAME + " in " + HOST_NAME + "@" + IP_ADRESS;}

    //kockanak felszin es terfogata
    @PostMapping("/cube/{sideLength}")
    HullData postCube(@PathVariable int sideLength) {
        HullData response = new HullData();
        response.setSurface((sideLength * sideLength) * 6);
        response.setVolume(sideLength * sideLength * sideLength);
        return response;
    }

    //kulonbozo oldalhosszakkal
    @PostMapping("cube/{sideLength}/{otherSideLength}")
    HullData postCube(@PathVariable int sideLength, @PathVariable int otherSideLength) {
        HullData response = new HullData();
        response.setSurface(sideLength * sideLength * 2 + sideLength * otherSideLength *2 + otherSideLength * otherSideLength * 2);
        response.setVolume(sideLength * sideLength * otherSideLength);
        return response;
    }

    //json obj-t kap, kind-tol fuggoen adja vissza a felszint, terfogatot
    @PostMapping("/hull")
    HullData postHull(@RequestBody HullRequestDTO body) {
        HullData response = new HullData();
        if(body.getKind() == Kind.CONE) {
            response.setSurface(0);
            response.setVolume(0);
            logList.add(new Log(response, body, System.currentTimeMillis()));
        } else if (body.getKind() == Kind.CUBE){
            response.setSurface(1);
            response.setVolume(1);
            logList.add(new Log(response, body, System.currentTimeMillis()));
        } else if (body.getKind() == Kind.CYLINDER){
            response.setSurface(2);
            response.setVolume(2);
            logList.add(new Log(response, body, System.currentTimeMillis()));
        } else if (body.getKind() == Kind.PRISM){
            response.setSurface(3);
            response.setVolume(3);
            logList.add(new Log(response, body, System.currentTimeMillis()));
        } else if (body.getKind() == Kind.SPHERE){
            response.setSurface(4);
            response.setVolume(4);
            logList.add(new Log(response, body, System.currentTimeMillis()));
        } else {
            System.out.println("Hullrequest kind is not valid.");
        }
        return  response;
    }

    // lista teljes tartalma idorendben
    @GetMapping("/logs")
    List getLogs() {
        return logList.stream().sorted(Comparator.comparingLong(Log::getTimeStamp)).collect(Collectors.toList());
    }

    // adott fajta testek listazasa
    @GetMapping("/logs/{kind}")
    List getLogs2(@PathVariable Kind kind) {
        return logList.stream().filter(k -> kind.equals(k.getHullDataDTO().getKind())).collect(Collectors.toList());
    }




}
