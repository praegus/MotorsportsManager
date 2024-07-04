import { expect, test } from 'vitest'
import { render, screen } from '@testing-library/react'
import Home from '../../src/pages/index'
import { vi } from "vitest";

const mockPush = vi.fn();

vi.mock("next/router", () => {
  return {
    useRouter: () => ({
      push: mockPush,
    }),
  };
});

test('Home', () => {
  render(<Home />)
  expect(screen.getByText('Profile')).toBeTruthy()
})