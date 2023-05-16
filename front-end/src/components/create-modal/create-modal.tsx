import {useEffect, useState} from "react";
import {useFoodDateMutate} from "../../hooks/useFoodDateMutate";
import {FoodDate} from "../../interface/FoodDate";
import "./modal.css"

interface InputProps {
    label: string,
    value: string | number,

    updateValue(value: any): void
}

const Input = ({label, value, updateValue}: InputProps) => {
    return (
        <>
            <label>{label}</label>
            <input value={value}
                   onChange={event => updateValue(event.target.value)}>
            </input>
        </>
    )
}

interface ModalProps {
    closeModal(): void
}

export function CreateModal({closeModal}: ModalProps) {
    const [title, setTitle] = useState("");
    const [price, setPrice] = useState(0);
    const [image, setImage] = useState("");
    const {mutate, isSuccess, isLoading} = useFoodDateMutate();

    const submit = () => {
        const foodDate: FoodDate = {
            title,
            price,
            image
        }
        mutate(foodDate);
    }

    useEffect(() => {
        if (!isSuccess) return
        closeModal()
    }, [isSuccess])

    return (
        <div className={"modal-overlay"}>
            <div className={"modal-body"}>
                <h2>Cadastre um novo item no cardápio</h2>
                <form className={"input-container"}>
                    <Input label={"Nome"} value={title} updateValue={setTitle}></Input>
                    <Input label={"Preço"} value={price} updateValue={setPrice}></Input>
                    <Input label={"Imagem"} value={image} updateValue={setImage}></Input>
                </form>
                <button onClick={submit}
                        className={"btn-secondary"}>{isLoading ? "Salvando novo item no cardápio" : "Salvar"}</button>
            </div>
        </div>
    )
}