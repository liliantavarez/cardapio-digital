import axios, {AxiosPromise} from "axios";
import {FoodDate} from "../interface/FoodDate";
import {useMutation, useQueryClient} from "@tanstack/react-query"

const API_URL = "http://localhost:8080"

const postDate = async (data: FoodDate): AxiosPromise<any> => {
    return await axios.post(API_URL + "/food", data);
}

export function useFoodDateMutate() {
    const queryCliente = useQueryClient();
    const mutate = useMutation({
        mutationFn: postDate,
        retry: 2,
        onSuccess: () => {
            queryCliente.invalidateQueries(["food-data"])
        }
    })

    return mutate;

}