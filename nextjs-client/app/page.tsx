import Category from "./components/Category";

export default function Home() {
	return (
		<main className="flex min-h-screen flex-col items-center justify-start p-16">
			<div className="p-2">
				<h1 className="text-3xl text-center text-blue-600">Pleasant Hollow</h1>
				<p className="text-gray-400">An end-to-end secure modern discussion board.</p>
			</div>
			<div className="flex flex-col items-start justify-start p-4">
				<Category title="General" description="General discussion." />
				<Category title="General" description="General discussion." />
				<Category title="General" description="General discussion." />
				<Category title="General" description="General discussion." />
				<Category title="General" description="General discussion." />
				<Category title="General" description="General discussion." />
				<Category title="General" description="General discussion." />
			</div>
		</main>
	);
}
