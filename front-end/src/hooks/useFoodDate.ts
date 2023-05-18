import axios, {AxiosPromise} from "axios";
import {FoodDate} from "../interface/FoodDate";
import {useQuery} from "@tanstack/react-query"

const API_URL = "http://localhost:8080"

const fetchDate = async (): AxiosPromise<FoodDate[]> => {
    return await axios.get(API_URL + "/food");
}

export function useFoodDate() {
    const query = useQuery({
        queryFn: fetchDate,
        queryKey: ["food-data"],
        retry: 2
    })

    return {
        ...query,
        data: query.data?.data
    }

}