// noinspection TypeScriptValidateTypes

import './App.css'
import {Card} from "./components/card/card";
import {useFoodDate} from "./hooks/useFoodDate";
import {useState} from "react";
import {CreateModal} from "./components/create-modal/create-modal";

function App() {
    const {data} = useFoodDate();
    const [isModalOpen, setIsModalOpen] = useState(false);

    const handleOpenModal = () => {
        setIsModalOpen(prev => !prev)
    }

    return (
        <div className="container">
            <h1>Cardápio</h1>
            <div className="card-grid">
                {data?.map(
                    foodData =>
                        <Card key={foodData.id}
                              price={foodData.price}
                              title={foodData.title}
                              image={foodData.image}
                        />)}
            </div>
            {isModalOpen && <CreateModal closeModal={handleOpenModal}/>}
            <button onClick={handleOpenModal}>Adicionar novo item</button>
        </div>
    )
}

export default App
