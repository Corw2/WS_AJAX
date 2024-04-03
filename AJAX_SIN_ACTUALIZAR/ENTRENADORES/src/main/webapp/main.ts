type Trainer = {
  name: string;
  reputation: number;
  availableSlots: number;
};

type Client = {
  name: string;
  importance: number;
};

const trainers: Trainer[] = [
  {
    name: 'A',
    reputation: 4.5,
    availableSlots: 1,
  },
  {
    name: 'B',
    reputation: 3.2,
    availableSlots: 4,
  },
  {
    name: 'C',
    reputation: 1.2,
    availableSlots: 3,
  },
  {
    name: 'D',
    reputation: 3.4,
    availableSlots: 2,
  },
];

const clients: Client[] = [
  {
    name: 'q',
    importance: 2.6,
  },
  {
    name: 'r',
    importance: 3.7,
  },
  {
    name: 's',
    importance: 8.5,
  },
  {
    name: 't',
    importance: 9.7,
  },
  {
    name: 'u',
    importance: 2.6,
  },
  {
    name: 'v',
    importance: 4.7,
  },
  {
    name: 'w',
    importance: 5.6,
  },
  {
    name: 'x',
    importance: 3.7,
  },
  {
    name: 'y',
    importance: 8.1,
  },
  {
    name: 'z',
    importance: 2.5,
  },
];

const trainersSorted = trainers.sort((a, b) => b.reputation - a.reputation);
const clientsSorted = clients.sort((a, b) => b.importance - a.importance);

type TrainerWithClients = Trainer & {
  assignedClients: Client[];
};

const trainersWithClients: TrainerWithClients[] = [];

for (let index = 0; index < clientsSorted.length; index++) {
  const currentClient = clientsSorted[index];

  const availableTrainer = trainersSorted.find(
    (trainer) => trainer.availableSlots >= 1,
  );

  const newTrainer = { ...availableTrainer, assignedClients: [currentClient] };

  trainersWithClients.push(newTrainer);
}

trainersWithClients.forEach(({ name, reputation, assignedClients }) =>
  console.log({ name, reputation, assignedClients }),
);
