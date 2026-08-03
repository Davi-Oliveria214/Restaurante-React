import styles from '../css/HomePage.module.css'
import Carrossel from '../components/Carrossel'
import Banner from '../components/Banner'

export function HomePage() {
    return (
        <main className={styles.main}>
            <Banner />
            <Carrossel />
        </main>
    )
}